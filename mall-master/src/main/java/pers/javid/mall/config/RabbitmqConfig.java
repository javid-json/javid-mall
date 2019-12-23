package pers.javid.mall.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import pers.javid.mall.listener.UserOrderListener;
import pers.javid.mall.utils.QueueEnum;

@Configuration
public class RabbitmqConfig {
    private static final Logger log = LoggerFactory.getLogger(RabbitTemplate.class);
    @Autowired
    private Environment env;

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer rabbitConfigurer;

    @Autowired
    private UserOrderListener userOrderListener;
    //管理rabbitmq监听器的容器工厂
    @Bean(name = "singleListenerContainer")
    public SimpleRabbitListenerContainerFactory listenerConfig(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(1);
        factory.setPrefetchCount(1);
        factory.setTxSize(1);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

    //用于生产消息的组件
    @Bean
    public RabbitTemplate rabbitTemplate(){
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
            }
        });
        return rabbitTemplate;
    }

    //登陆用户消息模型
    @Bean(name="logUserQueue")
    public Queue logUserQueue(){
        return new Queue(env.getProperty("log.user.queue.name"),true);
    }

    @Bean
    public DirectExchange logUserExchange(){
        return new DirectExchange(env.getProperty("log.user.exchange.name"),true,false);
    }

    @Bean
    public Binding logUserBinding(){
        //使用exchange+routingkey的方式与队列建立纽带
        return BindingBuilder.bind(logUserQueue()).to(logUserExchange()).with(env.getProperty("log.user.routing.key.name"));
    }

    //用户抢单消息模型
    @Bean(name="userOrderQueue")
    public Queue userOrderQueue(){
        return new Queue(env.getProperty("user.order.queue.name"),true);
    }

    @Bean
    public TopicExchange userOrderExchange(){
        return new TopicExchange(env.getProperty("user.order.exchange.name"),true,false);
    }

    @Bean
    public Binding userOrderBinding(){
        //使用exchange+routingkey的方式与队列建立纽带
        return BindingBuilder.bind(userOrderQueue()).to(userOrderExchange()).with(env.getProperty("user.order.routing.key.name"));
    }

    @Bean
    public DirectExchange orderDirect(){
        return (DirectExchange)ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getName())
                .durable(true)
                .build();
    }

    @Bean
    public DirectExchange orderTtlDirect(){
        return (DirectExchange)ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getName())
                .durable(true)
                .build();
    }

    @Bean
    public Queue orderQueue(){
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getName(),true);
    }

    @Bean
    public Queue orderTtlQueue(){
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())
                .build();
    }

    @Bean
    public Binding orderBinding(){
        return BindingBuilder
                .bind(orderQueue())
                .to(orderDirect())
                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    @Bean
    public Binding orderTtlBinding(){
        return BindingBuilder
                .bind(orderTtlQueue())
                .to(orderTtlDirect())
                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }

    public SimpleMessageListenerContainer listenerContainerUserOrder(@Qualifier("userOrderQueue") Queue userOrderQueue){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageConverter(new Jackson2JsonMessageConverter());

        //并发配置
        container.setConcurrentConsumers(env.getProperty("spring.rabbitmq.listener.concurrency",Integer.class));
        container.setMaxConcurrentConsumers(env.getProperty("spring.rabbitmq.listener.max-concurrency",Integer.class));
        container.setPrefetchCount(env.getProperty("spring.rabbitmq.listener.prefetch",Integer.class));

        //消息确认机制
        container.setQueues(userOrderQueue);
        container.setMessageListener(userOrderListener);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        return container;
    }


}

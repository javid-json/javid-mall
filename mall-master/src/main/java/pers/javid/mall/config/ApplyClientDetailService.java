package pers.javid.mall.config;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * @author ：javid
 * @date ：Created in 2019-8-19
 * @description：${description}
 * @modified By：
 * @version: 1.0
 */
public class ApplyClientDetailService implements ClientDetailsService {

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return null;
    }
}

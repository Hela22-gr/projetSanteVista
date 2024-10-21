package com.SanteVista.SanteVista.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = ObjectUtils.asMap(
                "cloud_name", "dkvbwurbx",
                "api_key", "965348698957765",
                "api_secret", "mQTw6ch7YFbT-Fwbz6wyqY5cqyc"
        );
        return new Cloudinary(config);
    }
}

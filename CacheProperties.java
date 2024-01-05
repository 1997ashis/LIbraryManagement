package com.nt.redis;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Data
@Component
@ConfigurationProperties(prefix = "cache")
public class CacheProperties {
    private List<CacheInfo> caches;

    public void setCaches(List<CacheInfo> caches) {
        this.caches = caches;
    }

    @Getter
    public static class CacheInfo {
        private String name;
        private long ttlSeconds;

        public void setName(String name)
        {
            this.name = name;
        }

        public void setTtlSeconds(long ttlSeconds) {
            this.ttlSeconds = ttlSeconds;
        }
    }
}

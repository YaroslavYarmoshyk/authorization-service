package com.security.authorizationservice.model;

import com.security.authorizationservice.config.converter.RsaPrivateKeyConverter;
import com.security.authorizationservice.config.converter.RsaPublicKeyConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rsa_key_pairs")
public class RsaKeyPair {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "created", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant created;
    @Column(name = "publicKey", nullable = false, unique = true)
    @Convert(converter = RsaPublicKeyConverter.class)
    private RSAPublicKey publicKey;
    @Column(name = "privateKey", nullable = false)
    @Convert(converter = RsaPrivateKeyConverter.class)
    private RSAPrivateKey privateKey;
}

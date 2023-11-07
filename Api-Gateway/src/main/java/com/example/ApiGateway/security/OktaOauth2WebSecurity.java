package com.example.ApiGateway.security;


//@Configuration
//@EnableWebSecurity
public class OktaOauth2WebSecurity {

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .requestMatchers("/").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .oauth2Login()
////                .and()
////                .oauth2ResourceServer()
////                .jwt();
////        return http.build();
//        http
//                .authorizeExchange()
//                .anyExchange().authenticated()
//                .and()
//                .oauth2Login()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();
//    }
//
//    @Bean
//    public ClientRegistrationRepository clientRepository() {
//
//        ClientRegistration githubRegistration =
//                CommonOAuth2Provider.OKTA.getBuilder("okta")
//                        .clientId("id")
//                        .clientSecret("secret")
//                        .tokenUri("https://dev-89963674.okta.com/oauth2/default")
//                        .authorizationUri("https://dev-89963674.okta.com/oauth2/default")
//                        .build();
//
//        return new InMemoryClientRegistrationRepository(githubRegistration);
//    }
//
//    @Bean
//    public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
//        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
//    }
//
//    @Bean
//    public JWKSource<SecurityContext> jwkSource() {
//        KeyPair keyPair = generateRsaKey();
//        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//        RSAKey rsaKey = new RSAKey.Builder(publicKey)
//                .privateKey(privateKey)
//                .keyID(UUID.randomUUID().toString())
//                .build();
//        JWKSet jwkSet = new JWKSet(rsaKey);
//        return new ImmutableJWKSet<>(jwkSet);
//    }
//
//    private static KeyPair generateRsaKey() {
//        KeyPair keyPair;
//        try {
//            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//            keyPairGenerator.initialize(2048);
//            keyPair = keyPairGenerator.generateKeyPair();
//        }
//        catch (Exception ex) {
//            throw new IllegalStateException(ex);
//        }
//        return keyPair;
//    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login()
//        ;
//        return http.build();
//    }

}

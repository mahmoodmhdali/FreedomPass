/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomPass.api.configuration.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

public interface TokenAuthenticationService {

    void addAuthentication(HttpServletResponse res, Authentication authentication, boolean rememberMe);

    Authentication getAuthentication(HttpServletRequest request);

}

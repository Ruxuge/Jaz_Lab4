/*
package jaz.webapp;

import jaz.auth.ProfileService;
import jaz.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {

    @Inject
    private LoginRequest loginRequest;

    UIComponent usernameComponent;

    @Inject
    private ProfileService profileService;

    public String login(){
        System.out.println("Tried log in ");

        if(profileService.logIn(loginRequest.getUsername(), loginRequest.getPassword())){
            return "/index/";
        }


    }
}
*/

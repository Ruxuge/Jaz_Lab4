package jaz.controller;

import jaz.registration.HashPassword;
import jaz.request.RegistrationRequest;
import jaz.webapp.UserToDatabase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RegisterController
{
    @Inject
    private RegistrationRequest registrationRequest;

    @Inject
    UserToDatabase userToDatabase = new UserToDatabase();

    private HashPassword hashPassword = new HashPassword();

    public boolean register()
    {
        String hashedPassword = hashPassword.hash(registrationRequest.getPassword()); //hashing password


        if(userToDatabase.checkIfNickIsUnique(registrationRequest.getUsername()))
        {
            if(userToDatabase.checkIfEmailIsUnique(registrationRequest.getUserEmail()))
            {
                if (registrationRequest.getSecPassword().equals(registrationRequest.getPassword()))
                {
                    userToDatabase.addUserToDb(registrationRequest.getName(), registrationRequest.getLastName(), registrationRequest.getUsername(),
                            hashedPassword, registrationRequest.getUserEmail(), registrationRequest.getDateOfBirth());

                    return true;
                }
                else
                {
                    System.out.println("Passwords doesn't match: " + registrationRequest.getPassword() + "!=" + registrationRequest.getSecPassword());
                    return false;
                }
            }
            else
                return false;
        }
        else
        {
            return false;
        }
    }
}
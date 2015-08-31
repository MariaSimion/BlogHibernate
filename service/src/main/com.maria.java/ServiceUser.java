
import com.maria.UserFacade;
import com.maria.model.User;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;

/**
 * Created by msimion on 8/31/2015.
 */
@Path("/user")
public class ServiceUser {

    UserFacade userFacade;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveUser(User user) {
        userFacade.saveUser(user);
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}

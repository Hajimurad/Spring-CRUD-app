package crud.main;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements InitializingBean {

    private UserService userService;

    @Autowired
    public DataBaseInit(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void afterPropertiesSet() {
        userService.save(new User("Name1", "Surname1", "name1@gmail.com",
                "9999999998", 1999, 1, 10 ));
        userService.save(new User("Name2", "Surname2", "name2@gmail.com",
                "9999999997", 1998, 2, 11 ));
        userService.save(new User("Name3", "Surname3", "name3@gmail.com",
                "9999999996", 1997, 3, 12 ));
        userService.save(new User("Name4", "Surname4", "name4@gmail.com",
                "9999999995", 1996, 4, 13 ));
        userService.save(new User("Name5", "Surname5", "name5@gmail.com",
                "9999999994", 1995, 5, 14 ));
        userService.save(new User("Name6", "Surname6", "name6@gmail.com",
                "9999999993", 1994, 6, 15 ));

    }
}

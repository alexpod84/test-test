package common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return
                ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");
    String LOGIN = readConfig().getString("usersParams.userIvan.login");
    String PASSWORD = readConfig().getString("usersParams.userIvan.password");

    Integer IMPLICIT_WAIT = readConfig().getInt("implisit_wait");
    Integer EXPLICIT_WAIT = readConfig().getInt("explisit_wait");
}

package model;

/**
 *
 * @author Fernanda
 */
public class Util {

    public static final String JBOSS_CONFIG = System.getProperty("jboss.server.config.url").replace("file:", "");

    public static String getDadosCopaPath() {

        return JBOSS_CONFIG + "vispublica_copa2014/";
    }
}

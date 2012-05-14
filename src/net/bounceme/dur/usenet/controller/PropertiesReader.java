package net.bounceme.dur.usenet.controller;



import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {

    private static final Logger LOG = Logger.getLogger(PropertiesReader.class.getName());
    private static final Level LEVEL = Level.FINE;
    private static Properties props = new Properties();

    public static Properties getProps() {
        LOG.log(LEVEL, "NNTP.loadMessages...");
        try {
            props.load(PropertiesReader.class.getResourceAsStream("/usenet.properties"));
        } catch (IOException ex) {
            Logger.getLogger(PropertiesReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.getClass().getResourceAsStream("/nntp.properties");
        //logger.log(level, props.toString());
        return props;
    }
}
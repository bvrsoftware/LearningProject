package com.bvr.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loging {
    private Logger log = null;

    private Loging(Class cl) {
        log = LogManager.getLogger(cl);
    }

    public static Loging getInstance(Class className) {
        return new Loging(className);
    }
    public void flow(String str, Object... var) {
        log.info(str, var);
    }
    public void exception(String str, Exception e) {
        log.fatal(e.toString(), e);
    }

    public void exception(String str) {
        log.fatal(str);
    }
    public void testing(String str, Object... var) {
        log.debug(str, var);
    }
    public void init(String str, Object... var) {
        log.fatal(str, var);
    }
}

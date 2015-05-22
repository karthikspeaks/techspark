package com.cisco.trails.idgen;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/7/14
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class UUIDGenerator {

    public static String getUuid() {

        return UUID.randomUUID().toString();

    }
}

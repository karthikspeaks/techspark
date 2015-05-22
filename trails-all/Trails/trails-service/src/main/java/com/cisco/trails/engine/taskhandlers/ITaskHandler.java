package com.cisco.trails.engine.taskhandlers;

import com.cisco.trails.context.TaskContext;
import org.springframework.integration.Message;

/**
 * Created with IntelliJ IDEA.
 * User: Karthikmo
 * Date: 1/2/14
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ITaskHandler {

    public TaskContext execute(Message<?> inMessage);

}

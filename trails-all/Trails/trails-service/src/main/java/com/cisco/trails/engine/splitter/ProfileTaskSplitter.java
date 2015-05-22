package com.cisco.trails.engine.splitter;

import com.cisco.trails.context.ProfileContext;
import com.cisco.trails.context.TaskContext;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import java.util.ArrayList;
import java.util.Collection;


public class ProfileTaskSplitter {

    public Collection<Message<TaskContext>> split(ProfileContext profileContext) {

        System.out.println("Inside Splitter");
        Collection<Message<TaskContext>> taskContextMessages = new ArrayList<Message<TaskContext>>();
        for (TaskContext taskContext : profileContext.getTaskContexts()) {

            System.out.println("Inside Splitter->" + taskContext.getTaskType());
            taskContext.setDescription(profileContext.getDescription());
            taskContext.setHint(profileContext.getHint());
            taskContext.setSafeWord(profileContext.getSafeWord());

            Message<TaskContext> msg = MessageBuilder.withPayload(taskContext).setHeader("taskType", taskContext.getTaskType()).build();
            taskContextMessages.add(msg);

        }
        return taskContextMessages;
    }
}

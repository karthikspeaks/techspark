/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author kamohan2
 */
public class NewClass {

}

 @Documented
 @Inherited
 @Target(value = {ElementType.TYPE, ElementType.METHOD})
 @Retention(RetentionPolicy.SOURCE)
 @interface Karthik{

     public enum Status {ON,OFF};
     String author() default "Karthik";

     String status() default Status.OFF;

    
}

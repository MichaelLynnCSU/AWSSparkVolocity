package Controller;

import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static spark.Spark.*;

public class LayoutController {

    VelocityEngine ve;
    Properties props;



    public LayoutController() {


        ve = new VelocityEngine();

        get("/hello", (req, res) -> "Hello AWS Elastic Beanstalk World");

        get("/hello2", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", "Velocity World");

            // The vm files are located under the resources directory
            return new ModelAndView(model, "layout.vm");
        }, new VelocityTemplateEngine());

    }



}

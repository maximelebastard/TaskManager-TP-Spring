/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.istic.taa.taskmanager;

import fr.istic.taa.taskmanager.web.rest.*;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class TestApplication extends Application {

    /*public TestApplication() {
        super();

        // Configure swagger
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("0.1");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("io.swagger.resources");
        beanConfig.setScan(true);
    }*/

    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        //clazzes.add(StatusEndpoint.class);

        //clazzes.add(EpicResource.class);
        clazzes.add(SprintResource.class);
        //clazzes.add(StoryResource.class);
        clazzes.add(TaskResource.class);
        clazzes.add(UserResource.class);

        //clazzes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        //clazzes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return clazzes;
    }

}

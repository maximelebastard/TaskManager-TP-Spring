package fr.istic.taa.taskmanager.datafixtures;

import fr.istic.taa.taskmanager.domain.*;
import fr.istic.taa.taskmanager.service.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.QueryParam;
import java.util.Arrays;

@Controller
@RequestMapping
public class TestingDataFixtures {

    /**
     * Persistence context
     */
    @PersistenceContext
    private EntityManager em;


    /**
     * Services
     */
    @Autowired
    private UserService userService;
    @Autowired
    private EpicService epicService;
    @Autowired
    private StoryService storyService;
    @Autowired
    private SprintService sprintService;
    @Autowired
    private TaskService taskService;

    /**
     * Created objects
     */
    User joeDalton;
    User luckyLuke;
    Epic foundDaisyTown;
    Story haveSomeEntertainment;
    Story haveSomewhereToSleep;
    Story someComfortForOurHorses;
    Sprint buildNecessities;
    Sprint recruitASmith;
    Task buildASaloon;
    Task makeHotel;
    Task foundABank;
    Task buildAShelter;
    Task hireTheSmith;

    @RequestMapping("runDataFixtures")
    public @ResponseBody String run(
            @QueryParam(value = "dropBefore") boolean dropBefore
    ) {
        if(dropBefore)  {
            truncateAll();
        }

        createUsers();
        createEpics();
        createStories();
        createSprints();
        createTasks();

        return "OK";
    }

    /**
     * Truncates all the tables before inserting new data
     */
    @Transactional
    protected void truncateAll() {
        //em.getTransaction().begin();
        em.createNativeQuery("TRUNCATE TABLE task").executeUpdate();
        em.createNativeQuery("TRUNCATE TABLE epic").executeUpdate();
        em.createNativeQuery("TRUNCATE TABLE story").executeUpdate();
        em.createNativeQuery("TRUNCATE TABLE sprint").executeUpdate();
        em.createNativeQuery("TRUNCATE TABLE user").executeUpdate();
        //em.getTransaction().commit();

        /**
         *
         SET FOREIGN_KEY_CHECKS = 0;
         TRUNCATE TABLE task; TRUNCATE TABLE epic; TRUNCATE TABLE story; TRUNCATE TABLE sprint; TRUNCATE TABLE user; TRUNCATE TABLE user_feature_request;
         SET FOREIGN_KEY_CHECKS = 1; -- enable checking
         */
    }

    /**
     * Create test users
     */
    protected void createUsers() {
        joeDalton = User.builder().firstname("Joe").lastname("Dalton").build();
        userService.create(joeDalton);

        luckyLuke = User.builder().firstname("Lucky").lastname("Luke").build();
        userService.create(luckyLuke);
    }

    /**
     * Create test epics
     */
    protected void createEpics() {
        foundDaisyTown = Epic.builder()
                .summary("Found the new city called Daisy Town")
                .description("We found a great place to live ! Let's build a beautiful city and call it Daisy Town")
                .asker(luckyLuke) // Ce jeu d'essai ne prend pas en compte le caractère solitaire du personnage
                .build();
        epicService.create(foundDaisyTown);
    }

    protected void createStories() {
        haveSomeEntertainment = Story.builder()
                .summary("Have some places to entertain us")
                .description("I'm bored of this town, I need somewhere to have fun.")
                .asker(luckyLuke)
                .epic(foundDaisyTown)
                .build();
        storyService.create(haveSomeEntertainment);

        haveSomewhereToSleep = Story.builder()
                .summary("I want a real bed")
                .description("My horse is not really comfortable for the night")
                .asker(luckyLuke)
                .epic(foundDaisyTown)
                .build();
        storyService.create(haveSomewhereToSleep);

        someComfortForOurHorses = Story.builder()
                .summary("Build something to take care of our horses")
                .description("My horse is tired. We need places to let them relax")
                .asker(luckyLuke)
                .epic(foundDaisyTown)
                .build();
        storyService.create(someComfortForOurHorses);
    }

    protected void createSprints() {
        buildNecessities = Sprint.builder()
                .name("Make necessities to live")
                .stories(Arrays.asList(haveSomewhereToSleep, haveSomeEntertainment))
                .dueDate(DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime("03/06/1883"))
                .build();
        sprintService.create(buildNecessities);

        recruitASmith = Sprint.builder()
                .name("Recruit a smith and provide him tools")
                .stories(Arrays.asList(someComfortForOurHorses))
                .startDate(DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime("28/06/1883"))
                .dueDate(DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime("12/07/1883"))
                .build();
        sprintService.create(recruitASmith);
    }

    protected void createTasks() {
        buildASaloon = Task.builder()
                .summary("Build a brand new saloon")
                .description("Lets make a beautiful place to drink and kill people !")
                .timeRequiredInHours(250)
                .story(haveSomeEntertainment)
                .sprint(buildNecessities)
                .timeSpentInHours(0)
                .done(false)
                .worker(joeDalton)
                .build();
        taskService.create(buildASaloon);

        makeHotel = Task.builder()
                .summary("Make an hotel")
                .description("Build a 20 rooms hotel, to have somewhere to sleep")
                .timeRequiredInHours(450)
                .story(haveSomewhereToSleep)
                .sprint(buildNecessities)
                .timeSpentInHours(200)
                .done(false)
                .worker(joeDalton)
                .build();
        taskService.create(makeHotel);

        foundABank = Task.builder()
                .summary("Found a bank")
                .description("Have a place where we can leave our loved money")
                .timeRequiredInHours(300)
                .sprint(buildNecessities)
                .timeSpentInHours(320)
                .done(true)
                .worker(luckyLuke)
                .build();
        taskService.create(foundABank);

        buildAShelter = Task.builder()
                .summary("Build a shelter")
                .description("Craft somewhere our horses can relax")
                .timeRequiredInHours(100)
                .story(someComfortForOurHorses)
                .sprint(recruitASmith)
                .timeSpentInHours(32)
                .done(false)
                .worker(joeDalton)
                .build();
        taskService.create(buildAShelter);

        hireTheSmith = Task.builder()
                .summary("Hire the smith")
                .description("Find a smith on the far-west would'nt last too long...")
                .timeRequiredInHours(2)
                .story(someComfortForOurHorses)
                .sprint(recruitASmith)
                .timeSpentInHours(350)
                .done(false)
                .worker(luckyLuke)
                .build();
        taskService.create(hireTheSmith);
    }
}

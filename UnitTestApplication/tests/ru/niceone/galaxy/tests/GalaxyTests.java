package ru.niceone.galaxy.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.niceone.galaxy.environment.Environment;
import ru.niceone.galaxy.environment.things.LightSwitch;
import ru.niceone.galaxy.environment.things.Match;
import ru.niceone.galaxy.human.Arthur;
import ru.niceone.galaxy.human.Ford;

public class GalaxyTests {

    private Environment env;

    @Before
    public void init_env_hum_test() {
        env = new Environment();
    }

    @Test
    public void hum_test() {
        String expectedState = "Low hum is sounding.";

        Assert.assertEquals(expectedState, env.hum.getStatement());
    }

    @Test
    public void lightswitch_test() {
        String expectedState = "Lightswitch is off.";
        LightSwitch lswitch = new LightSwitch();
        Assert.assertEquals(expectedState, lswitch.getStatement());
    }

    @Test
    public void match_test_off() {
        String expectedBaseState = "Match is off.";

        Match newMatch = new Match();
        Assert.assertEquals(expectedBaseState, newMatch.getStatement());
    }

    @Test
    public void match_test_on() {
        String expectedActiveState = "Match is on.";

        Match newMatch = new Match();

        newMatch.struckMatch();
        Assert.assertEquals(expectedActiveState, newMatch.getStatement());
    }

    @Test
    public void air_test_without_smell() {
        String expectedBaseState = "Air is clear from the smells.";

        Assert.assertEquals(expectedBaseState, env.air.getStatement());
    }

    @Test
    public void air_test_with_smell() {
        String expectedActiveState = "There is thick and musty smell.";

        env.air.smellInTheAir();
        Assert.assertEquals(expectedActiveState, env.air.getStatement());
    }

    @Test
    public void shadows_test() {
        String expectedBaseState = "Monstrous shadows stopped.";
        Assert.assertEquals(expectedBaseState, env.shadows.getStatement());
    }

    @Test
    public void shadows_test_leaping() {
        String expectedLeapingState = "Monstrous shadows leaping.";


        env.shadows.toLeap();
        Assert.assertEquals(expectedLeapingState, env.shadows.getStatement());
    }

    @Test
    public void shadows_test_looming() {
        String expectedLeapingState = "Monstrous shadows looming.";


        env.shadows.toLoom();
        Assert.assertEquals(expectedLeapingState, env.shadows.getStatement());
    }

    @Test
    public void shadows_test_leaping_loomong() {
        String expectedLeapingLoomingState = "Monstrous shadows leaping and looming.";


        env.shadows.toLeap();

        env.shadows.toLoom();
        Assert.assertEquals(expectedLeapingLoomingState, env.shadows.getStatement());
    }

    @Test
    public void arthur_test() {
        String expectedBaseState = Arthur.LYING_STATE;

        Arthur arthur = new Arthur();
        Assert.assertEquals(expectedBaseState, arthur.getStatement());
    }

    @Test
    public void arthur_test_ready() {
        String expectedReadyState = Arthur.READY_STATE;

        Arthur arthur = new Arthur();

        arthur.getUp();
        Assert.assertEquals(expectedReadyState, arthur.getStatement());
    }

    @Test
    public void arthur_test_active() {
        String expectedActiveState = Arthur.ACTIVE_STATE;

        Arthur arthur = new Arthur();

        arthur.getUp();
        arthur.hugYourself();
        Assert.assertEquals(expectedActiveState, arthur.getStatement());
    }

    @Test
    public void arthur_test_air_without_smell() {
        String expectedBreathClearAir = "There is no smell.";

        Arthur arthur = new Arthur();

        arthur.makeBreath(env.air);
        Assert.assertEquals(expectedBreathClearAir, arthur.lungs.getStatement());
    }

    @Test
    public void arthur_test_with_smell() {
        String expectedBreathSmellOnAir = "There is thick and musty smell.";

        Arthur arthur = new Arthur();

        env.air.smellInTheAir();
        arthur.makeBreath(env.air);
        Assert.assertEquals(expectedBreathSmellOnAir, arthur.lungs.getStatement());
    }

    @Test
    public void ford_test_match_off() {
        String expectedBaseState = "Ford has match. Match is off.";

        Ford ford = new Ford();

        Assert.assertEquals(expectedBaseState, ford.getStatement());
    }

    @Test
    public void ford_test_match_on() {
        String expectedOnState = "Ford has match. Match is on.";

        Ford ford = new Ford();

        ford.findSwitch(env);
        Assert.assertEquals(expectedOnState, ford.getStatement());
    }
}

package ru.niceone.galaxy.tests;

import org.junit.Before;
import ru.niceone.galaxy.environment.*;
import ru.niceone.galaxy.environment.things.*;
import ru.niceone.galaxy.human.*;

import org.junit.Test;
import org.junit.Assert;

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
    public void match_test() {
        String expectedBaseState = "Match is off.";
        String expectedActiveState = "Match is on.";

        Match newMatch = new Match();
        Assert.assertEquals(expectedBaseState, newMatch.getStatement());

        newMatch.struckMatch();
        Assert.assertEquals(expectedActiveState, newMatch.getStatement());
    }

    @Before
    public void init_env_air_test() {
        env = new Environment();
    }

    @Test
    public void air_test() {
        String expectedBaseState = "Air is clear from the smells.";
        String expectedActiveState = "There is thick and musty smell.";

        Assert.assertEquals(expectedBaseState, env.air.getStatement());

        env.air.smellInTheAir();
        Assert.assertEquals(expectedActiveState, env.air.getStatement());
    }

    @Before
    public void init_env_shadows_test() {
        env = new Environment();
    }

    @Test
    public void shadows_test() {
        String expectedBaseState = "Monstrous shadows stopped.";
        String expectedLeapingState = "Monstrous shadows leaping.";
        String expectedLeapingLoomingState = "Monstrous shadows leaping and looming.";

        Assert.assertEquals(expectedBaseState, env.shadows.getStatement());

        env.shadows.toLeap();
        Assert.assertEquals(expectedLeapingState, env.shadows.getStatement());

        env.shadows.toLoom();
        Assert.assertEquals(expectedLeapingLoomingState, env.shadows.getStatement());
    }

    @Test
    public void arthur_test() {
        String expectedBaseState = Arthur.LYING_STATE;
        String expectedReadyState = Arthur.READY_STATE;
        String expectedActiveState = Arthur.ACTIVE_STATE;

        String expectedBreathClearAir = "There is no smell.";
        String expectedBreathSmellOnAir = "There is thick and musty smell.";

        Arthur arthur = new Arthur();
        Assert.assertEquals(expectedBaseState, arthur.getStatement());

        arthur.getUp();
        Assert.assertEquals(expectedReadyState, arthur.getStatement());

        arthur.hugYourself();
        Assert.assertEquals(expectedActiveState, arthur.getStatement());

        arthur.makeBreath(env.air);
        Assert.assertEquals(expectedBreathClearAir, arthur.lungs.getStatement());

        env.air.smellInTheAir();
        arthur.makeBreath(env.air);
        Assert.assertEquals(expectedBreathSmellOnAir, arthur.lungs.getStatement());
    }

    @Before
    public void init_env_ford_test() {
        env = new Environment();
    }

    @Test
    public void ford_test() {
        String expectedBaseState = "Ford has match. Match is off.";
        String expectedOnState = "Ford has match. Match is on.";

        Ford ford = new Ford();

        Assert.assertEquals(expectedBaseState, ford.getStatement());

        ford.findSwitch(env);
        Assert.assertEquals(expectedOnState, ford.getStatement());
    }
}

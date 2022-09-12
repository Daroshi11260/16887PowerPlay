package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.shplib.commands.Command;
import org.firstinspires.ftc.teamcode.shplib.utility.Clock;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class MoveArm extends Command {
    private final ArmSubsystem arm;
    private final Direction direction;
    private double startTime;

    public enum Direction {
        UP, DOWN, TOP, BOTTOM, MIDDLE
    }

    public MoveArm(ArmSubsystem arm, Direction direction) {
        // You MUST call the parent class constructor and pass through any subsystems you use
        super(arm);

        this.arm = arm;
        this.direction = direction;
    }

    @Override
    public void init() {
        startTime = Clock.seconds();
        if (direction == Direction.UP) arm.nextState();
        else if (direction == Direction.DOWN) arm.previousState();
        else if (direction == Direction.TOP) arm.setState(ArmSubsystem.State.TOP);
        else if (direction == Direction.MIDDLE) arm.setState(ArmSubsystem.State.MIDDLE);
        else if (direction == Direction.BOTTOM) arm.setState(ArmSubsystem.State.BOTTOM);
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return arm.atSetpoint() && Clock.hasElapsed(startTime, 0.5);
    }

    @Override
    public void end() {

    }
}

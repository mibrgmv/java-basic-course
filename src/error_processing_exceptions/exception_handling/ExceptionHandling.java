package error_processing_exceptions.exception_handling;

import objects_classes_packages.class_declaration.RobotConnection;
import objects_classes_packages.class_declaration.RobotConnectionException;
import objects_classes_packages.class_declaration.RobotConnectionManager;

public class ExceptionHandling {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i=1; i<=3; ++i) {
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                i = 10;
            } catch (RobotConnectionException e) {
                if (i == 3) {
                    throw e;
                }
            }
        }
    }
}

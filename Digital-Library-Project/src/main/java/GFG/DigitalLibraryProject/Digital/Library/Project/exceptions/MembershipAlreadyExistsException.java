package GFG.DigitalLibraryProject.Digital.Library.Project.exceptions;

public class MembershipAlreadyExistsException extends RuntimeException{

    public MembershipAlreadyExistsException()
    {
        super("Current User already has an active membership");
    }

}

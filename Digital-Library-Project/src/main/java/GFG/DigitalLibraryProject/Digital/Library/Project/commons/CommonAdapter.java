package GFG.DigitalLibraryProject.Digital.Library.Project.commons;

import GFG.DigitalLibraryProject.Digital.Library.Project.model.UserModel;

import java.util.List;

public interface CommonAdapter<E,M> {

    M save(E e);

    M update(E e);


}

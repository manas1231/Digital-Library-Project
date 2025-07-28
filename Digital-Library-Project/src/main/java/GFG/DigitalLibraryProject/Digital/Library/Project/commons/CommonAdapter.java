package GFG.DigitalLibraryProject.Digital.Library.Project.commons;

public interface CommonAdapter<E,M> {

    M save(E e);

    M update(E e);
}

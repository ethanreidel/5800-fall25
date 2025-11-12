inside a class, can have makeSnapshot() method, which allows for the state saving ability that you want.

e.g. 

public class Editor() {
    blah blah

    private makeSnapshop():
        returns clone of snapshot
    private restore(snapshop):
        reestores the current state of snapshot to the restored


}

the memento class is a limited interface that allows for getting some data form the snapshot like getName() and getSnapshotDate()
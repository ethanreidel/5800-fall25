package part5.core;

import java.util.ArrayList;

public class Folder {
    //can contain >= 0 files and >= 0 sub-folders
    //file class must be stored within a folder
    //if a folder is deleted, all files and sub-folders are deleted
    
    //folder acts as a node in a tree

    private String name;
    private Folder parent;
    private ArrayList<File> file_list;
    private ArrayList<Folder> child_folders;

    public Folder(String name) {
        this.name = name;
        this.file_list = new ArrayList<>();
        this.child_folders = new ArrayList<>();
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public Folder getParent() {
        return parent;
    }

    //methods for adding to files vs folders
    public void addFile(File child) {
        this.file_list.add(child);
    }

    public void addFolder(Folder child) {
        child.setParent(this);
        this.child_folders.add(child);
    }

    public boolean searchFolder(Folder current, Folder target, ArrayList<String> stack) {
        if (current.name.equals(target.name)) {
            String result = String.join("/", stack);
            System.out.println(String.format("Found %s folder at: %s", target.name, result));
            return true;
        } else {
            for (Folder child : current.child_folders) {
                stack.add(child.name);
                if (searchFolder(child, target, stack)) {
                    return true;
                }
                stack.remove(child.name);
            }
        }
        return false;
    }

    
    public void printChildren(Folder current, int depth) {
        System.out.print("\t".repeat(depth));
        System.out.println(String.format("/%s", current.name));
        
        for (Folder child : current.child_folders) {
            printChildren(child, depth+1);
        }
        
        if (!current.file_list.isEmpty()){
            for (File file: current.file_list) {
                System.out.print("\t".repeat(depth+1));
                System.out.println(String.format("- %s", file.get_name()));
            }
        }
    }

    public boolean removeFolder(Folder targetFolder) {
        if (targetFolder == null) {
            return false;
        }
        
        Folder parent = targetFolder.getParent();
        if (parent == null) {
            return false; //means we are at the root
        }
        
        ArrayList<Folder> kids = parent.child_folders;
        int at = -1;
        for (int i = 0; i < kids.size(); i++) {
            if (kids.get(i) == targetFolder) {
                at = i;
                break;
            }
        }
        if (at == -1) {
            return false;
        }

        kids.remove(at);
        clearSubtree(targetFolder);
        targetFolder.setParent(null);
        return true;

    }

    private static void clearSubtree(Folder curr) {
        ArrayList<Folder> snapshot = new ArrayList<>(curr.child_folders);
        for (Folder child : snapshot) {
            clearSubtree(child);
            child.setParent(null);
        }
        curr.child_folders.clear();
        if (curr.file_list != null) {
            curr.file_list.clear();
        }
    }



    //each folder should initialize with an empty file array since we dont need to traverse that via dfs

    
    



    //seems like our recursive base case is when we file_list and folder_list are empty?


}

package src.part5;

import src.part5.core.File;
import src.part5.core.Folder;

public class CompositionDriver {

    public static void main(String[] args) {
        Folder demo1 = new Folder("demo1");
        Folder Source_Files = new Folder("Source Files");
        Folder phalcon = new Folder(".phalcon");
        Folder app = new Folder("app");
        Folder config = new Folder("config");
        Folder controllers = new Folder("controllers");
        Folder library = new Folder("library");
        Folder migrations = new Folder("migrations");
        Folder models = new Folder("models");
        Folder views = new Folder("views");
        
        Folder cache = new Folder("cache");
        Folder public_ = new Folder("public");

        File htaccess = new File(".htaccess");
        File router = new File(".htrouter.php");
        File index = new File("index.html");

        Folder Include_path = new Folder("Include Path");
        Folder Remote_files = new Folder("Remote Files");


        demo1.addFolder(Source_Files);
        Source_Files.addFolder(phalcon);
        Source_Files.addFolder(app);

        app.addFolder(config);
        app.addFolder(controllers);
        app.addFolder(library);
        app.addFolder(migrations);
        app.addFolder(models);
        app.addFolder(views);

        Source_Files.addFolder(cache);
        Source_Files.addFolder(public_);

        Source_Files.addFile(htaccess);
        Source_Files.addFile(router);
        Source_Files.addFile(index);

        demo1.addFolder(Include_path);

        demo1.addFolder(Remote_files);
        int depth = 0;
        demo1.printChildren(demo1, depth);
        
        System.out.println("\n\n\n\n----------\n\n\n\n");
                
        demo1.removeFolder(app);

        depth = 0;
        demo1.printChildren(demo1, depth);

        System.out.println("\n\n\n\n----------\n\n\n\n");

        demo1.removeFolder(public_);

        depth=0;
        demo1.printChildren(demo1, depth);

    }
} 

package org.logstash.previous_ackedqueue;


import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class PersistentPagedQueue extends PagedQueue {
    private String dirPath;

    // @param dirPath directory path where all queue data files will be written
    // @param pageSize the pageSize when creating a new queue, if the queue already exists, its configured page size will be used
    public PersistentPagedQueue(String dirPath, int pageSize) throws FileNotFoundException {
        // TODO: PersistentQueueState?
        super(new VolatileQueueState(pageSize));
        this.dirPath = dirPath;

        Path p = FileSystems.getDefault().getPath(this.dirPath);

        if (Files.notExists(p, LinkOption.NOFOLLOW_LINKS)) {
            throw new FileNotFoundException(this.dirPath);
        }
    }

    // page is basically the byte buffer
    // @param index the page index to retrieve
    protected Page page(int index) {
        return null;
    }
}

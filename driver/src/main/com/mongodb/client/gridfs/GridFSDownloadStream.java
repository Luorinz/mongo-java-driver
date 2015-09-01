/*
 * Copyright 2015 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.client.gridfs;

import com.mongodb.MongoGridFSException;
import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.client.gridfs.model.GridFSFile;

import java.io.InputStream;

/**
 * A GridFS InputStream for downloading data from GridFS
 *
 * <p>Provides the {@code GridFSFile} for the file to being downloaded as well as the {@code read} methods of a {@link InputStream}</p>
 *
 * <p>This implementation of a {@code InputStream} will not throw {@link @IOException}s. However, it  will throw a
 * {@link com.mongodb.MongoException} if there is an error reading from MongoDB.</p>
 *
 * @since 3.1
 */
@NotThreadSafe
public abstract class GridFSDownloadStream extends InputStream {

    /**
     * Gets the corresponding {@link GridFSFile} for the file being downloaded
     *
     * @return the corresponding GridFSFile for the file being downloaded
     */
    public abstract GridFSFile getGridFSFile();

    @Override
    public abstract int read();

    @Override
    public abstract int read(byte[] b);

    @Override
    public abstract int read(byte[] b, int off, int len);

    @Override
    public abstract long skip(long n);

    @Override
    public abstract int available();

    @Override
    public void reset() {
        throw new MongoGridFSException("Reset not supported");
    }

    @Override
    public abstract void close();
}
/*
 * Copyright 2019 Albert Tregnaghi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */
package de.jcup.asciidoctoreditor.asciidoc;

import java.io.File;
import java.util.Map;
import java.util.Objects;

import de.jcup.asp.api.asciidoc.AsciidocAttributes;
import de.jcup.asp.api.asciidoc.AsciidocOptions;
import de.jcup.asp.client.AspClientProgressMonitor;

public interface AsciidoctorAdapter {

    void convertFile(File editorFileOrNull, File asciiDocFile, AsciidocOptions options, AsciidocAttributes attributes, AspClientProgressMonitor monitor);

    default public Map<String, Object> resolveAttributes(File fileOrDirectory) {
        Objects.requireNonNull(fileOrDirectory, "File path must be set!");
        return AsciiDocAttributeResolver.DEFAULT.resolveAttributes(fileOrDirectory);

    }

}

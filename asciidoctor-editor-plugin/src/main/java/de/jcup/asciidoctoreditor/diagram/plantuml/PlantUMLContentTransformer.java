/*
 * Copyright 2018 Albert Tregnaghi
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
package de.jcup.asciidoctoreditor.diagram.plantuml;

import de.jcup.asciidoctoreditor.AbstractContentTransformer;
import de.jcup.asciidoctoreditor.ContentTransformerData;

public class PlantUMLContentTransformer extends AbstractContentTransformer {

    private PlantUMLDataProvider provider;

    public void setDataProvider(PlantUMLDataProvider provider) {
        this.provider = provider;
    }

    @Override
    protected String saveTransform(ContentTransformerData data) {
        StringBuilder sb = new StringBuilder();
        if (data.origin != null) {
            sb.append("[plantuml");
            if (data.filename != null && !data.filename.isEmpty()) {
                sb.append(",");
                sb.append(data.filename);
            }
            if (provider != null) {
                PlantUMLOutputFormat format = provider.getOutputFormat();
                if (format != null) {
                    sb.append(",");
                    sb.append(format.getAsciiDocFormatString());
                }
            }
            sb.append("]\n----\n");
            sb.append(data.origin);
            sb.append("\n----\n");
        }
        return sb.toString();
    }

    @Override
    public boolean isTransforming(Object data) {
        return true;
    }

}

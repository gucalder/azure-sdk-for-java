/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.cognitiveservices.computervision;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object describing a single recognized line of text.
 */
public class OcrLine {
    /**
     * Bounding box of a recognized line. The four integers represent the
     * x-coordinate of the left edge, the y-coordinate of the top edge, width,
     * and height of the bounding box, in the coordinate system of the input
     * image, after it has been rotated around its center according to the
     * detected text angle (see textAngle property), with the origin at the
     * top-left corner, and the y-axis pointing down.
     */
    @JsonProperty(value = "boundingBox")
    private String boundingBox;

    /**
     * An array of objects, where each object represents a recognized word.
     */
    @JsonProperty(value = "words")
    private List<OcrWord> words;

    /**
     * Get the boundingBox value.
     *
     * @return the boundingBox value
     */
    public String boundingBox() {
        return this.boundingBox;
    }

    /**
     * Set the boundingBox value.
     *
     * @param boundingBox the boundingBox value to set
     * @return the OcrLine object itself.
     */
    public OcrLine withBoundingBox(String boundingBox) {
        this.boundingBox = boundingBox;
        return this;
    }

    /**
     * Get the words value.
     *
     * @return the words value
     */
    public List<OcrWord> words() {
        return this.words;
    }

    /**
     * Set the words value.
     *
     * @param words the words value to set
     * @return the OcrLine object itself.
     */
    public OcrLine withWords(List<OcrWord> words) {
        this.words = words;
        return this;
    }

}

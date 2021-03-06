/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * @author Nikolay A. Kuznetsov
 */
package java.util.regex;

/**
 * Node accepting substrings in unicode case insensitive manner.
 * 
 * @author Nikolay A. Kuznetsov
 */
class UCISequenceSet extends LeafSet {
    
    private String string = null;

    UCISequenceSet(StringBuffer substring) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < substring.length(); i++) {
            res.append(Character.toLowerCase(Character.toUpperCase(substring
                    .charAt(i))));
        }
        this.string = res.toString();
        this.charCount = res.length();
    }

    public int accepts(int strIndex, CharSequence testString) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != Character.toLowerCase(Character
                    .toUpperCase(testString.charAt(strIndex + i)))) {
                return -1;
            }
        }

        return string.length();

    }

    public String getName() {
        return "UCI sequence: " + string; //$NON-NLS-1$
    }
}

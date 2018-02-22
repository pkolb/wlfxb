/**
 * wlfxb - a library for creating and processing of TCF data streams.
 *
 * Copyright (C) University of Tübingen.
 *
 * This file is part of wlfxb.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 *
 */
package eu.clarin.weblicht.wlfxb.tc.xb;

import eu.clarin.weblicht.wlfxb.tc.api.Lemma;
import eu.clarin.weblicht.wlfxb.utils.CommonAttributes;
import java.util.Arrays;
import java.util.LinkedHashMap;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

/**
 * @author Yana Panchenko
 *
 */
@XmlRootElement(name = LemmaStored.XML_NAME)
@XmlAccessorType(XmlAccessType.NONE)
public class LemmaStored implements Lemma {

    public static final String XML_NAME = "lemma";
    public static final String ID_PREFIX = "l_";
    @XmlValue
    protected String lemmaString;
    @XmlAttribute(name = CommonAttributes.ID)
    protected String lemmaId;
    @XmlAttribute(name = CommonAttributes.TOKEN_SEQUENCE_REFERENCE, required = true)
    protected String[] tokRefs;
    @XmlAnyAttribute
    protected LinkedHashMap<QName, String> qnameAttributes = new LinkedHashMap<QName, String>();
    protected LinkedHashMap<String, String> extraAttributes = new LinkedHashMap<String, String>();

    @Override
    public String getString() {
        return lemmaString;
    }

    @Override
    public String getLemmaId() {
        return lemmaId;
    }

    @Override
    public LinkedHashMap<String, String> getExtraAtrributes() {
        for (QName qName : qnameAttributes.keySet()) {
            extraAttributes.put(qName.toString(), qnameAttributes.get(qName).toString());
        }
        return extraAttributes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lemmaId != null) {
            sb.append(lemmaId);
            sb.append(" -> ");
        }
        sb.append(lemmaString).append(" ").append(Arrays.toString(tokRefs));
        return sb.toString();
    }

}

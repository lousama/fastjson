package com.alibaba.json.bvt.parser.deser;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.FloatCodec;

public class FloatDeserializerTest extends TestCase {

    public void test_bigdecimal() throws Exception {
        Assert.assertEquals(0, JSON.parseObject("0", Float.class).intValue());
        Assert.assertEquals(0, JSON.parseObject("0.0", Float.class).intValue());
        Assert.assertEquals(0, JSON.parseObject("'0'", Float.class).intValue());

        Assert.assertEquals(null, JSON.parseObject("null", Float.class));

        DefaultExtJSONParser parser = new DefaultExtJSONParser("null", ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
        Assert.assertEquals(null, FloatCodec.instance.deserialze(parser, null, null));
        Assert.assertEquals(JSONToken.LITERAL_INT, FloatCodec.instance.getFastMatchToken());
    }
}


package name.wramner.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * Unit test for {@link HexDumpEncoder}
 * 
 * @author Erik Wramner
 */
public class HexDumpEncoderTest {
    private final sun.misc.HexDumpEncoder _sunEncoder = new sun.misc.HexDumpEncoder();
    private final name.wramner.util.HexDumpEncoder _ourEncoder = new name.wramner.util.HexDumpEncoder();
    private final byte[][] BYTE_ARRAY_ARRAY = createTestData();

    @Test
    public void testEncodeBufferByteArray() {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            assertEquals(_sunEncoder.encodeBuffer(byteArray), _ourEncoder.encodeBuffer(byteArray));
        }
    }

    @Test
    public void testEncodeBufferByteArrayOutputStream() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteArrayOutputStream sunBos = new ByteArrayOutputStream();
            _sunEncoder.encodeBuffer(byteArray, sunBos);

            ByteArrayOutputStream ourBos = new ByteArrayOutputStream();
            _ourEncoder.encodeBuffer(byteArray, ourBos);

            assertArrayEquals(sunBos.toByteArray(), ourBos.toByteArray());
        }
    }

    @Test
    public void testEncodeBufferByteBufferOutputStream() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteBuffer sunBuffer = ByteBuffer.wrap(byteArray);
            ByteBuffer ourBuffer = sunBuffer.duplicate();

            ByteArrayOutputStream sunBos = new ByteArrayOutputStream();
            _sunEncoder.encodeBuffer(sunBuffer, sunBos);

            ByteArrayOutputStream ourBos = new ByteArrayOutputStream();
            _ourEncoder.encodeBuffer(ourBuffer, ourBos);

            assertArrayEquals(sunBos.toByteArray(), ourBos.toByteArray());
        }
    }

    @Test
    public void testEncodeBufferByteBuffer() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteBuffer sunBuffer = ByteBuffer.wrap(byteArray);
            ByteBuffer ourBuffer = sunBuffer.duplicate();
            assertEquals(_sunEncoder.encodeBuffer(sunBuffer), _ourEncoder.encodeBuffer(ourBuffer));
        }
    }

    @Test
    public void testEncodeBufferInputStreamOutputStream() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteArrayInputStream sunBis = new ByteArrayInputStream(byteArray);
            ByteArrayInputStream ourBis = new ByteArrayInputStream(byteArray);

            ByteArrayOutputStream sunBos = new ByteArrayOutputStream();
            _sunEncoder.encodeBuffer(sunBis, sunBos);

            ByteArrayOutputStream ourBos = new ByteArrayOutputStream();
            _ourEncoder.encodeBuffer(ourBis, ourBos);

            assertArrayEquals(sunBos.toByteArray(), ourBos.toByteArray());
        }
    }

    @Test
    public void testEncodeByteArray() {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            assertEquals(_sunEncoder.encode(byteArray), _ourEncoder.encode(byteArray));
        }
    }

    @Test
    public void testEncodeByteArrayOutputStream() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteArrayOutputStream sunBos = new ByteArrayOutputStream();
            _sunEncoder.encode(byteArray, sunBos);

            ByteArrayOutputStream ourBos = new ByteArrayOutputStream();
            _ourEncoder.encode(byteArray, ourBos);

            assertArrayEquals(sunBos.toByteArray(), ourBos.toByteArray());
        }
    }

    @Test
    public void testEncodeByteBufferOutputStream() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteBuffer sunBuffer = ByteBuffer.wrap(byteArray);
            ByteBuffer ourBuffer = sunBuffer.duplicate();

            ByteArrayOutputStream sunBos = new ByteArrayOutputStream();
            _sunEncoder.encode(sunBuffer, sunBos);

            ByteArrayOutputStream ourBos = new ByteArrayOutputStream();
            _ourEncoder.encode(ourBuffer, ourBos);

            assertArrayEquals(sunBos.toByteArray(), ourBos.toByteArray());
        }
    }

    @Test
    public void testEncodeByteBuffer() {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteBuffer sunBuffer = ByteBuffer.wrap(byteArray);
            ByteBuffer ourBuffer = sunBuffer.duplicate();
            assertEquals(_sunEncoder.encode(sunBuffer), _ourEncoder.encode(ourBuffer));
        }
    }

    @Test
    public void testEncodeInputStreamOutputStream() throws IOException {
        for (byte[] byteArray : BYTE_ARRAY_ARRAY) {
            ByteArrayInputStream sunBis = new ByteArrayInputStream(byteArray);
            ByteArrayInputStream ourBis = new ByteArrayInputStream(byteArray);

            ByteArrayOutputStream sunBos = new ByteArrayOutputStream();
            _sunEncoder.encode(sunBis, sunBos);

            ByteArrayOutputStream ourBos = new ByteArrayOutputStream();
            _ourEncoder.encode(ourBis, ourBos);

            assertArrayEquals(sunBos.toByteArray(), ourBos.toByteArray());
        }
    }

    private static byte[][] createTestData() {
        byte[][] arrayOfByteArrays = new byte[10000][];
        for (int i = 0; i < arrayOfByteArrays.length; i++) {
            arrayOfByteArrays[i] = new byte[i];
            for (int j = 0; j < i; j++) {
                arrayOfByteArrays[i][j] = (byte) j;
            }
        }
        return arrayOfByteArrays;
    }
}

/*
 * Copyright 2020-2024 Deephaven Data Labs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.deephaven.barrage.flatbuf;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class BarrageSnapshotOptions extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_24_3_25(); }
  public static BarrageSnapshotOptions getRootAsBarrageSnapshotOptions(ByteBuffer _bb) { return getRootAsBarrageSnapshotOptions(_bb, new BarrageSnapshotOptions()); }
  public static BarrageSnapshotOptions getRootAsBarrageSnapshotOptions(ByteBuffer _bb, BarrageSnapshotOptions obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public BarrageSnapshotOptions __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * Deephaven reserves a value in the range of primitives as a custom NULL value. This enables more efficient transmission
   * by eliminating the additional complexity of the validity buffer.
   */
  public boolean useDeephavenNulls() { int o = __offset(6); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  /**
   * Specify a preferred batch size. Server is allowed to be configured to restrict possible values. Too small of a
   * batch size may be dominated with header costs as each batch is wrapped into a separate RecordBatch. Too large of
   * a payload and it may not fit within the maximum payload size. A good default might be 4096.
   */
  public int batchSize() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  /**
   * Specify a maximum allowed message size. Server will enforce this limit by reducing batch size (to a lower limit
   * of one row per batch). If the message size limit cannot be met due to large row sizes, the server will throw a
   * `Status.RESOURCE_EXHAUSTED` exception
   */
  public int maxMessageSize() { int o = __offset(10); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  /**
   * The maximum length of any list / array to encode.
   * - If zero, list lengths will not be limited.
   * - If non-zero, the server will limit the length of any encoded list / array to the absolute value of the returned length.
   * - If less than zero, the server will encode elements from the end of the list / array, rather than from the beginning.
   *
   * Note: The server is unable to indicate when truncation occurs. To detect truncation request one more element than
   * the maximum number you wish to display.
   */
  public long previewListLengthLimit() { int o = __offset(12); return o != 0 ? bb.getLong(o + bb_pos) : 0L; }

  public static int createBarrageSnapshotOptions(FlatBufferBuilder builder,
      boolean useDeephavenNulls,
      int batchSize,
      int maxMessageSize,
      long previewListLengthLimit) {
    builder.startTable(5);
    BarrageSnapshotOptions.addPreviewListLengthLimit(builder, previewListLengthLimit);
    BarrageSnapshotOptions.addMaxMessageSize(builder, maxMessageSize);
    BarrageSnapshotOptions.addBatchSize(builder, batchSize);
    BarrageSnapshotOptions.addUseDeephavenNulls(builder, useDeephavenNulls);
    return BarrageSnapshotOptions.endBarrageSnapshotOptions(builder);
  }

  public static void startBarrageSnapshotOptions(FlatBufferBuilder builder) { builder.startTable(5); }
  public static void addUseDeephavenNulls(FlatBufferBuilder builder, boolean useDeephavenNulls) { builder.addBoolean(1, useDeephavenNulls, false); }
  public static void addBatchSize(FlatBufferBuilder builder, int batchSize) { builder.addInt(2, batchSize, 0); }
  public static void addMaxMessageSize(FlatBufferBuilder builder, int maxMessageSize) { builder.addInt(3, maxMessageSize, 0); }
  public static void addPreviewListLengthLimit(FlatBufferBuilder builder, long previewListLengthLimit) { builder.addLong(4, previewListLengthLimit, 0L); }
  public static int endBarrageSnapshotOptions(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public BarrageSnapshotOptions get(int j) { return get(new BarrageSnapshotOptions(), j); }
    public BarrageSnapshotOptions get(BarrageSnapshotOptions obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}


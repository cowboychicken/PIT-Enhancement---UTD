/*
 * Copyright 2010 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;

public enum ArithmeticOperatorReplacementMutator7 implements MethodMutatorFactory {

  MATH_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
      final MethodVisitor methodVisitor) {
    return new MathMethodVisitor7(this, methodInfo, context, methodVisitor);
  }

  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

  @Override
  public String getName() {
    return name();
  }

}

class MathMethodVisitor7 extends AbstractInsnMutator {

  MathMethodVisitor7(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {

    // ints

    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IXOR, "Replaced integer addition with XOR"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.ISHL, "Replaced integer subtraction with Shift Left"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.ISHR, "Replaced integer multiplication with Shift Right"));
    MUTATIONS.put(Opcodes.IDIV,
        new InsnSubstitution(Opcodes.IUSHR, "Replaced integer division with Unsigned Shift Right"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IADD, "Replaced bitwise OR with addition"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISUB, "Replaced bitwise AND with subtraction"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IMUL, "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IDIV, "Replaced XOR with division"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IOR, "Replaced Shift Left with OR"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IAND, "Replaced Shift Right with AND"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IREM, "Replaced Unsigned Shift Right with modulus"));

    // longs
    //

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LXOR, "Replaced integer addition with XOR"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LSHL, "Replaced integer subtraction with Shift Left"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LSHR, "Replaced integer multiplication with Shift Right"));
    MUTATIONS.put(Opcodes.LDIV,
        new InsnSubstitution(Opcodes.LUSHR, "Replaced integer division with Unsigned Shift Right"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LADD, "Replaced bitwise OR with addition"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LSUB, "Replaced bitwise AND with subtraction"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LMUL, "Replaced integer modulus with multiplication"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LDIV, "Replaced XOR with division"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LOR, "Replaced Shift Left with OR"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LAND, "Replaced Shift Right with AND"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LREM, "Replaced Unsigned Shift Right with modulus"));

    // floats
    // Covered already in first five files

    // doubles
    // Covered already in first five files

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

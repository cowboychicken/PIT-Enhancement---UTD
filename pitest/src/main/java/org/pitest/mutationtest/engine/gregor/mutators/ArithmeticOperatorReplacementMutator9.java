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

public enum ArithmeticOperatorReplacementMutator9 implements MethodMutatorFactory {

  MATH_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
      final MethodVisitor methodVisitor) {
    return new MathMethodVisitor9(this, methodInfo, context, methodVisitor);
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

class MathMethodVisitor9 extends AbstractInsnMutator {

  MathMethodVisitor9(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {

    // ints

    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISHR, "Replaced integer addition with Shift Right"));
    MUTATIONS.put(Opcodes.ISUB,
        new InsnSubstitution(Opcodes.IUSHR, "Replaced integer subtraction with Unsigned Shift Right"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IADD, "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISUB, "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IMUL, "Replaced bitwise OR with multiplication"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IDIV, "Replaced bitwise AND with division"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IOR, "Replaced integer modulus with OR"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IAND, "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IREM, "Replaced Shift Left with modulus"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IXOR, "Replaced Shift Right with XOR"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISHL, "Replaced Unsigned Shift Right with Shift Left"));

    // longs
    //

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSHR, "Replaced integer addition with Shift Right"));
    MUTATIONS.put(Opcodes.LSUB,
        new InsnSubstitution(Opcodes.LUSHR, "Replaced integer subtraction with Unsigned Shift Right"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LADD, "Replaced integer multiplication with addition"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSUB, "Replaced integer division with subtraction"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LMUL, "Replaced bitwise OR with multiplication"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LDIV, "Replaced bitwise AND with division"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LOR, "Replaced integer modulus with OR"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LAND, "Replaced XOR with AND"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LREM, "Replaced Shift Left with modulus"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LXOR, "Replaced Shift Right with XOR"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSHL, "Replaced Unsigned Shift Right with Shift Left"));

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

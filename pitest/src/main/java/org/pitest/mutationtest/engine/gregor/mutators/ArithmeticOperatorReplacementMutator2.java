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

public enum ArithmeticOperatorReplacementMutator2 implements MethodMutatorFactory {

  MATH_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
      final MethodVisitor methodVisitor) {
    return new MathMethodVisitor2(this, methodInfo, context, methodVisitor);
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

class MathMethodVisitor2 extends AbstractInsnMutator {

  MathMethodVisitor2(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {

    // ints

    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IMUL, "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IDIV, "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IOR, "Replaced integer multiplication with OR"));
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IAND, "Replaced integer division with AND"));
    MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IREM, "Replaced bitwise OR with modulus"));
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IXOR, "Replaced bitwise AND with XOR"));
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISHL, "Replaced integer modulus with Shift Left"));
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHR, "Replaced XOR with Shift Right"));
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IUSHR, "Replaced Shift Left with Unsigned Shift Right"));
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IADD, "Replaced Shift Right with addition"));
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.ISUB, "Replaced Unsigned Shift Right with subtraction"));

    // longs

    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LMUL, "Replaced integer addition with multiplication"));
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LDIV, "Replaced integer subtraction with division"));
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LOR, "Replaced integer multiplication with OR"));
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LAND, "Replaced integer division with AND"));
    MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LREM, "Replaced bitwise OR with modulus"));
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LXOR, "Replaced bitwise AND with XOR"));
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LSHL, "Replaced integer modulus with Shift Left"));
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LSHR, "Replaced XOR with Shift Right"));
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LUSHR, "Replaced Shift Left with Unsigned Shift Right"));
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LADD, "Replaced Shift Right with addition"));
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LSUB, "Replaced Unsigned Shift Right with subtraction"));

    // floats
    MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FMUL, "Replaced float addition with multiplication"));
    MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FDIV, "Replaced float subtraction with division"));
    MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FREM, "Replaced float multiplication with modulus"));
    MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FADD, "Replaced float division with addition"));
    MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FSUB, "Replaced float modulus with subtraction"));

    // doubles
    MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DMUL, "Replaced double addition with multiplication"));
    MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DDIV, "Replaced double subtraction with division"));
    MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DREM, "Replaced double multiplication with modulus"));
    MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DADD, "Replaced double division with addition"));
    MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DSUB, "Replaced double modulus with subtraction"));

  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}

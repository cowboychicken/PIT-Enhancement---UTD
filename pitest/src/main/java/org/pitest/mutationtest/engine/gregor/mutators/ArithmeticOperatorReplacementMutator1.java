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

public enum ArithmeticOperatorReplacementMutator1 implements MethodMutatorFactory {

    MATH_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
            final MethodVisitor methodVisitor) {
        return new MathMethodVisitor1(this, methodInfo, context, methodVisitor);
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

class MathMethodVisitor1 extends AbstractInsnMutator {

    MathMethodVisitor1(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
            final MethodVisitor writer) {
        super(factory, methodInfo, context, writer);
    }

    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

    static {
        // ints
        MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.ISUB, "Replaced integer addition with subtraction"));
        MUTATIONS.put(Opcodes.ISUB,
                new InsnSubstitution(Opcodes.IMUL, "Replaced integer subtraction with multiplication"));
        MUTATIONS.put(Opcodes.IMUL,
                new InsnSubstitution(Opcodes.IDIV, "Replaced integer multiplication with division"));
        MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IOR, "Replaced integer division with OR"));
        MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IAND, "Replaced bitwise OR with AND"));
        MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IREM, "Replaced bitwise AND with modulus"));
        MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IXOR, "Replaced integer modulus with XOR"));
        MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISHL, "Replaced XOR with Shift Left"));
        MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISHR, "Replaced Shift Left with Shift Right"));
        MUTATIONS.put(Opcodes.ISHR,
                new InsnSubstitution(Opcodes.IUSHR, "Replaced Shift Right with Unsigned Shift Right"));
        MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IADD, "Replaced Unsigned Shift Right with addition"));

        // longs

        MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LSUB, "Replaced integer addition with subtraction"));
        MUTATIONS.put(Opcodes.LSUB,
                new InsnSubstitution(Opcodes.LMUL, "Replaced integer subtraction with multiplication"));
        MUTATIONS.put(Opcodes.LMUL,
                new InsnSubstitution(Opcodes.LDIV, "Replaced integer multiplication with division"));
        MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LOR, "Replaced integer division with OR"));
        MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LAND, "Replaced bitwise OR with AND"));
        MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LREM, "Replaced bitwise AND with modulus"));
        MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LXOR, "Replaced integer modulus with XOR"));
        MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LSHL, "Replaced XOR with Shift Left"));
        MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSHR, "Replaced Shift Left with Shift Right"));
        MUTATIONS.put(Opcodes.LSHR,
                new InsnSubstitution(Opcodes.LUSHR, "Replaced Shift Right with Unsigned Shift Right"));
        MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LADD, "Replaced Unsigned Shift Right with addition"));

        // floats
        MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FSUB, "Replaced float addition with subtraction"));
        MUTATIONS.put(Opcodes.FSUB,
                new InsnSubstitution(Opcodes.FMUL, "Replaced float subtraction with multiplication"));
        MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FDIV, "Replaced float multiplication with division"));
        MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FREM, "Replaced float division with modulus"));
        MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FADD, "Replaced float modulus with addition"));

        // doubles
        MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DSUB, "Replaced double addition with subtraction"));
        MUTATIONS.put(Opcodes.DSUB,
                new InsnSubstitution(Opcodes.DMUL, "Replaced double subtraction with multiplication"));
        MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DDIV, "Replaced double multiplication with division"));
        MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DREM, "Replaced double division with modulus"));
        MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DADD, "Replaced double modulus with addition"));

    }

    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
        return MUTATIONS;
    }

}

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

public enum ArithmeticOperatorReplacementMutator3 implements MethodMutatorFactory {

    MATH_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
            final MethodVisitor methodVisitor) {
        return new MathMethodVisitor3(this, methodInfo, context, methodVisitor);
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

class MathMethodVisitor3 extends AbstractInsnMutator {

    MathMethodVisitor3(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
            final MethodVisitor writer) {
        super(factory, methodInfo, context, writer);
    }

    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

    static {

        // ints

        MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IDIV, "Replaced integer addition with division"));
        MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IOR, "Replaced integer subtraction with OR"));
        MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IAND, "Replaced integer multiplication with AND"));
        MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IREM, "Replaced integer division with modulus"));
        MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.IXOR, "Replaced bitwise OR with XOR"));
        MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHL, "Replaced bitwise AND with Shift Left"));
        MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.ISHR, "Replaced integer modulus with Shift Right"));
        MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IUSHR, "Replaced XOR with Unsigned Shift Right"));
        MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IADD, "Replaced Shift Left with addition"));
        MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.ISUB, "Replaced Shift Right with subtraction"));
        MUTATIONS.put(Opcodes.IUSHR,
                new InsnSubstitution(Opcodes.IMUL, "Replaced Unsigned Shift Right with multiplication"));

        // longs
        //

        MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LDIV, "Replaced integer addition with division"));
        MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LOR, "Replaced integer subtraction with OR"));
        MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LAND, "Replaced integer multiplication with AND"));
        MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LREM, "Replaced integer division with modulus"));
        MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.LXOR, "Replaced bitwise OR with XOR"));
        MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LSHL, "Replaced bitwise AND with Shift Left"));
        MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LSHR, "Replaced integer modulus with Shift Right"));
        MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LUSHR, "Replaced XOR with Unsigned Shift Right"));
        MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LADD, "Replaced Shift Left with addition"));
        MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LSUB, "Replaced Shift Right with subtraction"));
        MUTATIONS.put(Opcodes.LUSHR,
                new InsnSubstitution(Opcodes.LMUL, "Replaced Unsigned Shift Right with multiplication"));

        // floats
        MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FDIV, "Replaced float addition with division"));
        MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FREM, "Replaced float subtraction with modulus"));
        MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.FADD, "Replaced float multiplication with addition"));
        MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FSUB, "Replaced float division with subtraction"));
        MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FMUL, "Replaced float modulus with multiplication"));

        // doubles
        MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DDIV, "Replaced double addition with division"));
        MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DREM, "Replaced double subtraction with modulus"));
        MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.DADD, "Replaced double multiplication with addition"));
        MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DSUB, "Replaced double division with subtraction"));
        MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DMUL, "Replaced double modulus with multiplication"));

    }

    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
        return MUTATIONS;
    }

}

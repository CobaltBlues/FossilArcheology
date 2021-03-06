package mods.fossil.client;

import mods.fossil.Fossil;

public class DinoSound
{
    public static final String SOUND_RESOURCE_LOCATION = Fossil.modid + ":";
    public static final String SOUND_PREFIX = Fossil.modid + ":";

    public static String[] files =
    {
        SOUND_RESOURCE_LOCATION + "ankylosaurus_death.wav",
        SOUND_RESOURCE_LOCATION + "ankylosaurus_hurt1.wav",
        SOUND_RESOURCE_LOCATION + "ankylosaurus_hurt2.wav",
        SOUND_RESOURCE_LOCATION + "ankylosaurus_living1.wav",
        SOUND_RESOURCE_LOCATION + "ankylosaurus_living2.wav",
        SOUND_RESOURCE_LOCATION + "ankylosaurus_living3.wav",
        SOUND_RESOURCE_LOCATION + "brachiosaurus_death1.wav",
        SOUND_RESOURCE_LOCATION + "brachiosaurus_living2.wav",
        SOUND_RESOURCE_LOCATION + "brachiosaurus_living1.wav",
        SOUND_RESOURCE_LOCATION + "brachiosaurus_hurt1.wav",
        SOUND_RESOURCE_LOCATION + "dilophosaurus_call1.wav",
        SOUND_RESOURCE_LOCATION + "dilophosaurus_call2.wav",
        SOUND_RESOURCE_LOCATION + "dilophosaurus_death.wav",
        SOUND_RESOURCE_LOCATION + "dilophosaurus_hurt.wav",
        SOUND_RESOURCE_LOCATION + "dilophosaurus_living.wav",
        SOUND_RESOURCE_LOCATION + "dodo_living1.wav",
        SOUND_RESOURCE_LOCATION + "dodo_living2.wav",
        SOUND_RESOURCE_LOCATION + "dodo_hurt1.wav",
        SOUND_RESOURCE_LOCATION + "dodo_death1.wav",
        SOUND_RESOURCE_LOCATION + "drum_single.wav",
        SOUND_RESOURCE_LOCATION + "drum_triple.wav",
        SOUND_RESOURCE_LOCATION + "mammoth_death.wav",
        SOUND_RESOURCE_LOCATION + "mammoth_hurt.wav",
        SOUND_RESOURCE_LOCATION + "mammoth_living.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_attack1.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_death1.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_death2.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_hurt.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_living1.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_living2.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_outside1.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_outside2.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_outside3.wav",
        SOUND_RESOURCE_LOCATION + "mosasaurus_outside4.wav",
        SOUND_RESOURCE_LOCATION + "plesiosaurus_hurt.wav",
        SOUND_RESOURCE_LOCATION + "plesiosaurus_living.wav",
        SOUND_RESOURCE_LOCATION + "pterosaurus_hurt.wav",
        SOUND_RESOURCE_LOCATION + "pterosaurus_living1.wav",
        SOUND_RESOURCE_LOCATION + "pterosaurus_living2.wav",
        SOUND_RESOURCE_LOCATION + "smilodon_death.wav",
        SOUND_RESOURCE_LOCATION + "smilodon_hurt.wav",
        SOUND_RESOURCE_LOCATION + "smilodon_living1.wav",
        SOUND_RESOURCE_LOCATION + "smilodon_living2.wav",
        SOUND_RESOURCE_LOCATION + "smilodon_living3.wav",
        SOUND_RESOURCE_LOCATION + "stegosaurus_death.wav",
        SOUND_RESOURCE_LOCATION + "stegosaurus_hurt.wav",
        SOUND_RESOURCE_LOCATION + "stegosaurus_living1.wav",
        SOUND_RESOURCE_LOCATION + "stegosaurus_living2.wav",
        SOUND_RESOURCE_LOCATION + "stegosaurus_living3.wav",
        SOUND_RESOURCE_LOCATION + "triceratops_death.wav",
        SOUND_RESOURCE_LOCATION + "triceratops_living1.wav",
        SOUND_RESOURCE_LOCATION + "triceratops_living2.wav",
        SOUND_RESOURCE_LOCATION + "triceratops_living3.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_death1.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_death2.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_hurt.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_living1.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_living2.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_living3.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_scream1.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_scream2.wav",
        SOUND_RESOURCE_LOCATION + "tyrannosaurus_scream3.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_attack1.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_attack2.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_hurt.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_living_tame1.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_living_tame2.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_living_wild1.wav",
        SOUND_RESOURCE_LOCATION + "velociraptor_living_wild2.wav",
        SOUND_RESOURCE_LOCATION + "whip1.wav",
        SOUND_RESOURCE_LOCATION + "tar.wav",

    };

    /*
     * ITEMS
     */

    //drum
    public static final String drum_single = SOUND_PREFIX + "drum_single";
    public static final String drum_triple = SOUND_PREFIX + "drum_triple";

    //whip
    public static final String whip = SOUND_PREFIX + "whip";

    /*
     * ENVIRONMENTAL
     */

    //tar
    public static final String tar = SOUND_PREFIX + "tar";

    /*
     * ENTITIES
     */

    //ankylosaurus
    public static final String ankylosaurus_death = SOUND_PREFIX + "ankylosaurus_death";
    public static final String ankylosaurus_living = SOUND_PREFIX + "ankylosaurus_living";
    public static final String ankylosaurus_hurt = SOUND_PREFIX + "ankylosaurus_hurt";

    //brachiosaurus
    public static final String brachiosaurus_death = SOUND_PREFIX + "brachiosaurus_death";
    public static final String brachiosaurus_living = SOUND_PREFIX + "brachiosaurus_living";
    public static final String brachiosaurus_hurt = SOUND_PREFIX + "brachiosaurus_hurt";
    
    //compsognathus
    public static final String compsognathus_death = SOUND_PREFIX + "velociraptor_death";
    public static final String compsognathus_living_tame = SOUND_PREFIX + "velociraptor_living_tame";
    public static final String compsognathus_living_wild = SOUND_PREFIX + "velociraptor_living_wild";
    public static final String compsognathus_hurt = SOUND_PREFIX + "velociraptor_hurt";
    public static final String compsognathus_attack = SOUND_PREFIX + "velociraptor_attack";
    
    //deinonychus
    public static final String deinonychus_death = SOUND_PREFIX + "velociraptor_death";
    public static final String deinonychus_living_tame = SOUND_PREFIX + "velociraptor_living_tame";
    public static final String deinonychus_living_wild = SOUND_PREFIX + "velociraptor_living_wild";
    public static final String deinonychus_hurt = SOUND_PREFIX + "velociraptor_hurt";
    public static final String deinonychus_attack = SOUND_PREFIX + "velociraptor_attack";

    //dilophosaurus
    public static final String dilophosaurus_death = SOUND_PREFIX + "dilophosaurus_death";
    public static final String dilophosaurus_living = SOUND_PREFIX + "dilophosaurus_living";
    public static final String dilophosaurus_hurt = SOUND_PREFIX + "dilophosaurus_hurt";
    public static final String dilophosaurus_call = SOUND_PREFIX + "dilophosaurus_call";

    //dodo
    public static final String dodo_death = SOUND_PREFIX + "dodo_death";
    public static final String dodo_living = SOUND_PREFIX + "dodo_living";
    public static final String dodo_hurt = SOUND_PREFIX + "dodo_hurt";

    //mammoth
    public static final String mammoth_death = SOUND_PREFIX + "mammoth_death";
    public static final String mammoth_living = SOUND_PREFIX + "mammoth_living";
    public static final String mammoth_hurt = SOUND_PREFIX + "mammoth_hurt";

    //mosasaurus
    public static final String mosasaurus_death = SOUND_PREFIX + "mosasaurus_death";
    public static final String mosasaurus_living = SOUND_PREFIX + "mosasaurus_living";
    public static final String mosasaurus_hurt = SOUND_PREFIX + "mosasaurus_hurt";
    public static final String mosasaurus_attack = SOUND_PREFIX + "mosasaurus_attack";
    public static final String mosasaurus_outside = SOUND_PREFIX + "mosasaurus_outside";

    //pachycephalosaurus
    public static final String pachycephalosaurus_death = SOUND_PREFIX + "stegosaurus_death";
    public static final String pachycephalosaurus_living = SOUND_PREFIX + "stegosaurus_living";
    public static final String pachycephalosaurus_hurt = SOUND_PREFIX + "stegosaurus_hurt";
    
    //plesiosaurus
    public static final String plesiosaur_death = SOUND_PREFIX + "plesiosaurus_death";
    public static final String plesiosaur_living = SOUND_PREFIX + "plesiosaurus_living";
    public static final String plesiosaur_hurt = SOUND_PREFIX + "plesiosaurus_hurt";

    //pterosaurus
    public static final String pterosaur_death = SOUND_PREFIX + "pterosaurus_death";
    public static final String pterosaur_living = SOUND_PREFIX + "pterosaurus_living";
    public static final String pterosaur_hurt = SOUND_PREFIX + "pterosaurus_hurt";

    //smilodon
    public static final String smilodon_death = SOUND_PREFIX + "smilodon_death";
    public static final String smilodon_living = SOUND_PREFIX + "smilodon_living";
    public static final String smilodon_hurt = SOUND_PREFIX + "smilodon_hurt";

    //spinosaurus
    public static final String spinosaurus_death = SOUND_PREFIX + "tyrannosaurus_death";
    public static final String spinosaurus_living = SOUND_PREFIX + "tyrannosaurus_living";
    public static final String spinosaurus_hurt = SOUND_PREFIX + "tyrannosaurus_hurt";
    public static final String spinosaurus_scream = SOUND_PREFIX + "tyrannosaurus_scream";
    
    //stegosaurus
    public static final String stegosaurus_death = SOUND_PREFIX + "stegosaurus_death";
    public static final String stegosaurus_living = SOUND_PREFIX + "stegosaurus_living";
    public static final String stegosaurus_hurt = SOUND_PREFIX + "stegosaurus_hurt";

    //triceratops
    public static final String triceratops_death = SOUND_PREFIX + "triceratops_death";
    public static final String triceratops_living = SOUND_PREFIX + "triceratops_living";
    public static final String triceratops_hurt = SOUND_PREFIX + "triceratops_hurt";

    //tyrannosaurus
    public static final String tyrannosaurus_death = SOUND_PREFIX + "tyrannosaurus_death";
    public static final String tyrannosaurus_living = SOUND_PREFIX + "tyrannosaurus_living";
    public static final String tyrannosaurus_hurt = SOUND_PREFIX + "tyrannosaurus_hurt";
    public static final String tyrannosaurus_scream = SOUND_PREFIX + "tyrannosaurus_scream";

    //velociraptor
    public static final String velociraptor_death = SOUND_PREFIX + "velociraptor_death";
    public static final String velociraptor_living_tame = SOUND_PREFIX + "velociraptor_living_tame";
    public static final String velociraptor_living_wild = SOUND_PREFIX + "velociraptor_living_wild";
    public static final String velociraptor_hurt = SOUND_PREFIX + "velociraptor_hurt";
    public static final String velociraptor_attack = SOUND_PREFIX + "velociraptor_attack";
}

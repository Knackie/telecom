import { rtdbBindAsArray as bindAsArray, rtdbBindAsObject as bindAsObject, RTDBOptions } from '@posva/vuefire-core';
import { database } from 'firebase';
import Vue, { PluginFunction } from 'vue';
interface PluginOptions {
    bindName?: string;
    unbindName?: string;
    serialize?: RTDBOptions['serialize'];
    reset?: RTDBOptions['reset'];
    wait?: RTDBOptions['wait'];
}
declare module 'vue/types/vue' {
    interface Vue {
        $rtdbBind(name: string, reference: database.Reference | database.Query, options?: RTDBOptions): Promise<database.DataSnapshot>;
        $rtdbUnbind: (name: string, reset?: RTDBOptions['reset']) => void;
        $firebaseRefs: Readonly<Record<string, database.Reference>>;
        _firebaseSources: Readonly<Record<string, database.Reference | database.Query>>;
        _firebaseUnbinds: Readonly<Record<string, ReturnType<typeof bindAsArray | typeof bindAsObject>>>;
    }
}
declare type VueFirebaseObject = Record<string, database.Query | database.Reference>;
declare type FirebaseOption<V> = VueFirebaseObject | ((this: V) => VueFirebaseObject);
declare module 'vue/types/options' {
    interface ComponentOptions<V extends Vue> {
        firebase?: FirebaseOption<V>;
    }
}
export declare const rtdbPlugin: PluginFunction<PluginOptions>;
export {};

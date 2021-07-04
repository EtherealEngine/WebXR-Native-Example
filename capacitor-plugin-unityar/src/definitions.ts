declare module '@capacitor/core' {
  interface PluginRegistry {
    UnityAR: UnityARPlugin;
  }
}

export interface UnityARPlugin {
  execute(options: { value: string }): Promise<void>;
}

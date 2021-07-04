import { WebPlugin } from '@capacitor/core';
import { UnityARPlugin } from './definitions';

export class UnityARWeb extends WebPlugin implements UnityARPlugin {
  constructor() {
    super({
      name: 'UnityAR',
      platforms: ['web'],
    });
  }
async execute(options: { value: string }): Promise<void> {
    console.log('ECHO', options);
  }
}

const UnityAR = new UnityARWeb();

export { UnityAR };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(UnityAR);

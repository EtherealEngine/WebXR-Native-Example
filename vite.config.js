import fs from 'fs';
import { defineConfig } from 'vite';


export default defineConfig(() => {
    const pathCertCert = './certs/cert.pem';
    const pathCertKey = './certs/key.pem';
    let server;
    if (fs.existsSync(pathCertKey)) {
        server = {
            https: {
                key: fs.readFileSync(pathCertKey),
                cert: fs.readFileSync(pathCertCert)
            }
        }
    }

    

    return {
        plugins: [],
        server,
        resolve: {
            alias: {
                '@material-ui/icons': '@material-ui/icons/esm',
                "socket.io-client": "socket.io-client/dist/socket.io.js",
                "react-infinite-scroller": "react-infinite-scroller/dist/InfiniteScroll",
            }
        },
        define: {
            'process.env': process.env,
            'process.browser': process.browser,
        },
        build: {
            sourcemap: 'inline',
            outDir:'www',
            assetsDir: 'assets',
            rollupOptions: {
                output: {
                    manualChunks(id) {
                        if (id.includes('node_modules')) {
                            return id.toString().split('node_modules/')[1].split('/')[0].toString();
                        }        
                    }                     
                },
              
               
            }
        }
    }
})

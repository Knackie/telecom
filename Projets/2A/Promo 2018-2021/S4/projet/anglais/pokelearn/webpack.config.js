const path = require('path')

const {VueLoaderPlugin} = require('vue-loader')
const HtmlWebpackPlugin = require('html-webpack-plugin')
const CopyWebpackPlugin = require('copy-webpack-plugin')
const {CleanWebpackPlugin} = require('clean-webpack-plugin');
const {GenerateSW} = require('workbox-webpack-plugin');


module.exports = (env, argv) => ({
    mode: argv && argv.mode || 'development',
    devtool: (argv && argv.mode || 'development') === 'production' ? 'source-map' : 'eval',

    entry: './src/main.js',

    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: '[name].js'
    },

    node: false,

    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.js$/,
                loader: 'babel-loader'
            },
            {
                test: /\.tsx?$/,
                loader: "ts-loader"
            },
            {
                test: /\.(scss|sass|css)$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    {
                        loader: 'sass-loader',
                        options: {
                            implementation: require('sass'),
                            sassOptions: {
                                fiber: require('fibers'),
                            },
                        },
                    },
                ],
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: [
                    'file-loader',
                ],
            },
        ]
    },

    resolve: {
        extensions: [
            '.js',
            '.vue',
            '.json',
            '.ts'
        ],
        alias: {
            'vue$': 'vue/dist/vue.esm.js',
            '@': path.resolve(__dirname, 'src')
        }
    },

    plugins: [
        new CleanWebpackPlugin(),
        new VueLoaderPlugin(),
        new HtmlWebpackPlugin({
            template: path.resolve(__dirname, 'public', 'index.html'),
            inject: true
        }),
        new CopyWebpackPlugin([{
            from: path.resolve(__dirname, 'public'),
            to: path.resolve(__dirname, 'dist'),
            toType: 'dir'
        }]),
        new GenerateSW({
            swDest: 'sw.js',
            clientsClaim: true,
            skipWaiting: true,
        })
    ],

    optimization: {
        splitChunks: {
            chunks: 'all',
            minSize: 30000,
            maxSize: 0,
            cacheGroups: {
                vendors: {
                    test: /[\\/]node_modules[\\/]/,
                    priority: -10
                },
                default: {
                    minChunks: 2,
                    priority: -20,
                    reuseExistingChunk: true
                }
            }
        },
        runtimeChunk: {
            name: entrypoint => `runtime~${entrypoint.name}`
        },
        mangleWasmImports: true,
        removeAvailableModules: true,
        removeEmptyChunks: true,
        mergeDuplicateChunks: true
    },

    devServer: {
        compress: true,
        host: 'localhost',
        https: true,
        open: true,
        overlay: true,
        port: 9000,
        historyApiFallback: true,
        inline: true
    }
});

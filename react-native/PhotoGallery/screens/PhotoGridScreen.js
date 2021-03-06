import React, {useCallback, useEffect, useReducer} from 'react';
import {ActivityIndicator, StyleSheet, Text, View} from 'react-native';
import {getList} from '../api/picsum';
import PhotoGrid from '../components/PhotoGrid';
import {actionCreators, initialState, reducer} from '../reducers/photos';

function PhotoListScreen() {
  const [state, dispatch] = useReducer(reducer, initialState);

  const {photos, nextPage, loading, error} = state;

  const fetchPhotos = useCallback(async () => {
    dispatch(actionCreators.loading());

    getList(nextPage)
      .then(nextPhotos =>
        dispatch(actionCreators.success(nextPhotos, nextPage)),
      )
      .catch(e => dispatch(actionCreators.failure()));
  }, [nextPage]);

  useEffect(() => {
    fetchPhotos();
  }, []);

  if (photos.length === 0) {
    if (loading) {
      return (
        <View style={styles.container}>
          <ActivityIndicator animating={true} color={'gray'} />
        </View>
      );
    }

    if (error) {
      return (
        <View style={styles.container}>
          <Text>Something went wrong</Text>
        </View>
      );
    }
  }

  return (
    <PhotoGrid numColumns={3} photos={photos} onEndReached={fetchPhotos} />
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default PhotoListScreen;
